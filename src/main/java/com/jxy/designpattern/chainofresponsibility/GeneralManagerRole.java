package com.jxy.designpattern.chainofresponsibility;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/9 8:40]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class GeneralManagerRole extends AbstractApproveRole {

    public GeneralManagerRole(String name) {
        super(name);
    }

    @Override
    void doApprove(LeaveBill leaveBill) {
        long startTime = leaveBill.getStartDate().getTime();
        long endTime = leaveBill.getEndDate().getTime();
        if (endTime - startTime > 6 * 24 * 3600 * 1000 && endTime - startTime < 16 * 24 * 3600 * 1000) {
            System.out.println(this.name + "批准你请假，请假单名称:" + leaveBill.getTitle());
        } else {
            System.out.println("您的请假时间太长，没有人能批准，请辞职");
        }
    }
}
