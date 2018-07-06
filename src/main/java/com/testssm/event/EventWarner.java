package com.testssm.event;

/**
 * 事件告警器
 */
public interface EventWarner {
    enum Type {
        SYSTEM,
        OPERATION,
        OPERATION_BUYOUT,//收标
        OPERATION_REPAYMENT,//兑付
        OPERATION_REPAYMENT_SUCCESS_NOTIFY;//兑付成功通知小贷系统
    }

    enum Level {
        /**整个应用无法使用*/
        APP_UNAVAILABLE(0, "应用故障"),
        /**某个模块无法使用,例如:如果整个充值都无法使用*/
        MODULE_UNAVAILABLE(1, "功能故障"),
        /**组件的部分无法使用,例如:如果某个银行无法充值*/
        MODULE_PART_UNAVAILABLE(2, "部分功能故障"),
        /**系统可用性告警,例如:某个Redis宕机,但系统还能正常使用*/
        AVAILABILITY_WARN(3, "可用性告警");
        int level;
        String desc;

        Level(int level, String desc) {
            this.level = level;
            this.desc = desc;
        }

        public int getLevel() {
            return level;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**发送告警*/
    void sendWarn(Type type, Level level, String title, String message);

}
