package com.example.proxy.CGLIBProxy;

import com.example.proxy.staticProxy.SmsProxy;
import com.example.proxy.staticProxy.SmsService;
import com.example.proxy.staticProxy.SmsServiceImpl;

/**
 * @ClassName main
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/3/5
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
/**
 JDK 动态代理和 CGLIB 动态代理对比
 1.JDK 动态代理只能只能代理实现了接口的类或者直接代理接口，而 CGLIB 可以代理未实现任何接口的类。 另外， CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法。
 2.就二者的效率来说，大部分情况都是 JDK 动态代理更优秀，随着 JDK 版本的升级，这个优势更加明显。

 静态代理和动态代理的对比
 1.灵活性 ：动态代理更加灵活，不需要必须实现接口，可以直接代理实现类，并且可以不需要针对每个目标类都创建一个代理类。另外，静态代理中，接口一旦新增加方法，目标对象和代理对象都要进行修改，这是非常麻烦的！
 2.JVM 层面 ：静态代理在编译时就将接口、实现类、代理类这些都变成了一个个实际的 class 文件。而动态代理是在运行时动态生成类字节码，并加载到 JVM 中的。

 为什么 JDK 动态代理只能为接口生成代理？
 JDK 动态代理是为接口生成代理对象，该代理对象继承了 JAVA 标准类库 Proxy.java 类并且实现了目标对象。由于 JAVA 遵循单继承多实现原则所以 JDK 无法利用继承来为目标对象生产代理对象。

 */