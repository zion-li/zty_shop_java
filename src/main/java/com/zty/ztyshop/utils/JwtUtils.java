package com.zty.ztyshop.utils;

import com.google.common.collect.Maps;
import com.zty.ztyshop.common.BaseException;
import com.zty.ztyshop.common.BaseEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.*;

/**
 * jwt = HEADER + PAYLOAD + VERIFY SIGNATURE
 * <p>
 * 1.HEADER = 包含生成token使用的算法与token类型
 * {
 * "alg": "HS256", //ALGORITHM ,默认算法 哈希256
 * "typ": "JWT"  //TOKEN TYPE ,token类型
 * }
 * <p>
 * 2.PAYLOAD = 数据的载体
 * {
 * "sub": "1234567890", // 自定义数据
 * "name": "John Doe", // 自定义数据
 * "iat": 1516239022 // token起作用时间 、生产日期
 * }
 * <p>
 * 3. VERIFY SIGNATURE 签名验证
 *
 * @author 李佳 lijia@autoai.com
 * @version 1.0
 * @date 2021/2/24 7:50
 */
public class JwtUtils {

    /**
     * secret 密钥,动态生成的密钥
     */
    public static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * 生成token
     *
     * @param claims 要传送消息map
     * @return
     */
    public static String generate(Map<String, Object> claims) {

        Date nowDate = new Date();
        //7 天过期
        Date expireDate = AddDate(nowDate, 24 * 7);

        //jwt 头部信息
        Map<String, Object> header = Maps.newHashMap();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        return Jwts.builder().setHeader(header)
                .setIssuer("zion")
                //具体数据
                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(key)
                .compact();
    }

    /**
     * 校验签名是否正确
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            throw new BaseException(BaseEnum.JWT_ERROR);
        }
    }

    /**
     * 验证token是否失效
     *
     * @param token
     * @return true:过期   false:没过期
     */
    public static boolean isExpired(String token) {
        try {
            final Date expiration = getExpiration(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 直接Base64解密获取header内容
     *
     * @param token
     * @return
     */
    public static String getHeaderByBase64(String token) {
        String header = null;
        if (isSigned(token)) {
            try {
                byte[] header_byte = Base64.getDecoder().decode(token.split("\\.")[0]);
                header = new String(header_byte);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return header;
    }

    /**
     * 直接Base64解密获取payload内容
     *
     * @param token
     * @return
     */
    public static String getPayloadByBase64(String token) {
        String payload = null;
        if (isSigned(token)) {
            try {
                byte[] payload_byte = Base64.getDecoder().decode(token.split("\\.")[1]);
                payload = new String(payload_byte);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return payload;
    }

    /**
     * 获取payload 部分内容（即要传的信息）
     * 使用方法：如获取userId：getClaim(token).get("userId");
     *
     * @param token
     * @return
     */
    public static Claims getClaim(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new BaseException(BaseEnum.JWT_ERROR);
        }
        return claims;
    }


    /**
     * 校验是不是jwt签名
     *
     * @param token
     * @return
     */
    private static boolean isSigned(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .isSigned(token);
    }

    /**
     * 获取jwt失效时间
     */
    private static Date getExpiration(String token) {
        return getClaim(token).getExpiration();
    }

    /**
     * 时间加减法
     */
    private static Date AddDate(Date date, Integer hour) {
        if (null == date) {
            date = new Date();
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        return cal.getTime();
    }

    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("userId", "123");

        String jwt = generate(map);
        System.out.println(jwt);
        System.out.println(verify(jwt));
        System.out.println(isExpired(jwt));
        System.out.println(getClaim(jwt));
    }
}
