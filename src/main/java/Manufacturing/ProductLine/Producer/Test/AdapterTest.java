package Manufacturing.ProductLine.Producer.Test;

import Manufacturing.ProductLine.Producer.AppleProducer;
import Presentation.Protocol.OutputManager;

/**
 * 适配器模式测试类
 *
 * @author 孟繁霖
 * @date 2021/10/27 18:20
 */
public class AdapterTest {
    public static void main(String[] args) {
        OutputManager.getInstance().print(
                "利用适配器模式适配不同生产方式:",
                "利用適配器模式適配不同生產方式：",
                "Use adapter pattern to adapt to different production manners:");
        AppleProducer appleProducer = new AppleProducer("fine");//适配细加工生产方式
        appleProducer.produce();
        AppleProducer appleProducer1=new AppleProducer("rough");//适配粗加工生产方式
        appleProducer1.produce();
    }
}
