package Management.HumanResources.test;

import Management.HumanResources.LeaveRequest;
import Management.HumanResources.Manager.TestingManager;
import Management.HumanResources.Staff.Worker;
import Management.HumanResources.TeamLeader.TestingTeamLeader;
import Management.QualityTesting.QualityAssuranceDepartment;
import Presentation.Protocol.OutputManager;

/**
 * ChainOfResponsibility的测试类
 *
 * @author 尚丙奇
 * @since 2021-10-21 11:03
 */

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {

        // 设置语言
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        // 获取QualityAssurance部门的实例
        QualityAssuranceDepartment qualityTestingDepartment = QualityAssuranceDepartment.getInstance();

        // 创建该部门的经理
        TestingManager testingManager = new TestingManager();
        // 创建该部门的一个组长
        TestingTeamLeader testingTeamLeader1 = new TestingTeamLeader();
        // 创建该部门的一个员工
        Worker testingWorker = new Worker();

        testingManager.setName("Bear");

        testingTeamLeader1.setName("梁乔");
        testingTeamLeader1.setLeader(testingManager);

        testingWorker.setName("桥梁");
        testingWorker.setLeader(testingTeamLeader1);

        // 分别将其注册到该部门
        qualityTestingDepartment.register(testingManager);
        qualityTestingDepartment.register(testingTeamLeader1);
        qualityTestingDepartment.register(testingWorker);

        // 创建一条请假请求
        LeaveRequest request = new LeaveRequest();
        request.setRequestee(testingWorker);
        request.setDays(15);
        request.setReason("要去当山本");

        OutputManager.getInstance().print(
                request.toString(OutputManager.Lang.zh_CN),
                request.toString(OutputManager.Lang.zh_TW),
                request.toString(OutputManager.Lang.en)
        );

        testingWorker.handleRequest(request);
    }

}