package com.jxy.designpattern.chainofresponsibility;

import java.util.Calendar;
import java.util.Date;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/9 9:26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ChainClient {
    public static void main(String[] args) {
        AbstractApproveRole approveRole = new GroupLeaderRole("王组长");
        AbstractApproveRole approveRole2 = new ManagerRole("张经理");
        approveRole.setApproveRole(approveRole2);
        AbstractApproveRole approveRole3 = new GeneralManagerRole("李总经理");
        approveRole2.setApproveRole(approveRole3);


        LeaveBill leaveBill = new LeaveBill();
        leaveBill.setTitle("我申请请假了！");
        leaveBill.setContent("你到底让不让我请假！");
        leaveBill.setStartDate(new Date());
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) + 6);
        leaveBill.setEndDate(now.getTime());
        approveRole.doApprove(leaveBill);

    }
}
