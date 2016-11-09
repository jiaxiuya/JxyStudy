package com.jxy.designpattern.chainofresponsibility;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/8 17:23]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class AbstractApproveRole {

    protected AbstractApproveRole approveRole;

    protected String name;

    public AbstractApproveRole(String name) {
        this.name = name;
    }

    public void setApproveRole(AbstractApproveRole approveRole) {
        this.approveRole = approveRole;
    }

    abstract void doApprove(LeaveBill leaveBill);
}
