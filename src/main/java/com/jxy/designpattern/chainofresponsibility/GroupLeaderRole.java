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
public class GroupLeaderRole extends AbstractApproveRole {

    public GroupLeaderRole(String name) {
        super(name);
    }

    @Override
    void doApprove(LeaveBill leaveBill) {
        long startTime = leaveBill.getStartDate().getTime();
        long endTime = leaveBill.getEndDate().getTime();
        if (endTime - startTime <= 3 * 24 * 3600 * 1000) {
            System.out.println(this.name + "批准你请假，请假单名称:" + leaveBill.getTitle());
        } else {
            this.approveRole.doApprove(leaveBill);
        }
    }
}
