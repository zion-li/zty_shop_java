-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL COMMENT '用户唯一标识',
  `staff_id` int(11) NOT NULL COMMENT '发型师',
  `account` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '本次消费金额',
  `cash_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现金业绩-类型',
  `cash_account` decimal(10, 2) NOT NULL COMMENT '现金业绩',
  `cash_account_assistant` decimal(10, 2) NOT NULL COMMENT '现金业绩',
  `cash_jf` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '剪发业绩',
  `cash_jf_assistant` int(10) NULL DEFAULT NULL,
  `cash_tf` decimal(10, 2) NULL DEFAULT NULL COMMENT '烫发业绩',
  `cash_tf_assistant` int(10) NULL DEFAULT NULL,
  `cash_rf` decimal(10, 2) NULL DEFAULT NULL COMMENT '染发业绩',
  `cash_rf_assistant` int(10) NULL DEFAULT NULL,
  `cash_tp` decimal(10, 2) NULL DEFAULT NULL COMMENT '头皮业绩',
  `cash_tp_assistant` int(10) NULL DEFAULT NULL,
  `cash_zx` decimal(10, 2) NULL DEFAULT NULL COMMENT '造型业绩',
  `cash_zx_assistant` int(10) NULL DEFAULT NULL,
  `cash_yy` decimal(10, 2) NULL DEFAULT NULL COMMENT '营养业绩',
  `cash_yy_assistant` int(10) NULL DEFAULT NULL,
  `cash_sx` decimal(10, 2) NULL DEFAULT NULL COMMENT '水洗业绩',
  `cash_sx_assistant` int(10) NULL DEFAULT NULL,
  `cash_sj` decimal(10, 2) NULL DEFAULT NULL COMMENT '速焗业绩',
  `cash_sj_assistant` int(10) NULL DEFAULT NULL,
  `cash_sp` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品业绩',
  `cash_sp_desc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `cash_sp_assistant` int(10) NULL DEFAULT NULL,
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否作废',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Table structure for client_info
-- ----------------------------
DROP TABLE IF EXISTS `client_info`;
CREATE TABLE `client_info`  (
    `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '顾客姓名',
    `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
    `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系地址',
    `rank` int(11) NULL DEFAULT NULL COMMENT '用户等级',
    `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别（0女、1男）',
    `birthday` date NULL DEFAULT NULL COMMENT '顾客生日',
    `account` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '总共消费金额',
    `last_login` datetime(0) NULL DEFAULT NULL COMMENT '最近一次到店时间',
    `service_times` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '服务次数',
    `create_at` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '客户表';

-- ----------------------------
-- Table structure for client_rank
-- ----------------------------
DROP TABLE IF EXISTS `client_rank`;
CREATE TABLE `client_rank`  (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '级别名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '客户等级表';

-- ----------------------------
-- Table structure for staff_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工名称',
  `rank` int(11) NOT NULL COMMENT '员工职称',
  `birthday` date NULL DEFAULT NULL COMMENT '员工生日',
  `gender` tinyint(1) NOT NULL COMMENT '性别(0 女，1 男)',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系地址',
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `id_ard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `employment_date` date NOT NULL COMMENT '入职时间',
  `emergency_contact_person` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '紧急联系人姓名',
  `emergency_contact_mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '紧急联系人电话',
  `is_resign` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态（0 在职、1离职）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '员工表';

-- ----------------------------
-- Table structure for staff_rank
-- ----------------------------
DROP TABLE IF EXISTS `staff_rank`;
CREATE TABLE `staff_rank`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工职称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '员工职称表';


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '加密后的密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '登录用户表';
