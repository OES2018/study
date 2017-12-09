
三个实体类

运用了JAVA的绘图类—Graphics

1 在Applet中写字和画图
要创建一个Applet，必须让自己的类从java.allpet.Applet类继承即可。Applet类是一个抽象类，它提供了五个抽象方法，它们是：
init( )  applet初始化，在applet首次创建时执行。 
start()  applet开始正常运作。在每次applet画面在浏览器窗口中可见时调用，也在init()后调用。 
stop( )  停止运作。每当applet画面移出浏览器窗口的可见区域时调用，也是destroy( )前被调用。 
paint()  在applet窗口中或画布上写字画图。也在update()方法中被自动调用。 
destroy()废弃当前applet的实例。在applet从网页上重新装载时调用。
Graphics类在java.awt包中被声明。AWT(Abstract Windows Toolskit)的名称是抽象窗口工具包，是提供窗口及其组件的类库。写字和画图是用Graphics的drawXXX方法实现的。如drawString(String),drawLine(.)等。画图用的坐标系是原点在左上角，纵轴向下以象素为单位的坐标系。
下面我们给出一个简单的示例说明在Applet中写字和画图的基本方法。
例1 Applet中写字和画图的基本方法。
///
import java.awt.*;
import java.applet.*;
public class DrawBasic extends Applet {
   public void paint(Graphics g) {
        g.drawString("用Graphics写字和画图的基本方法", 20,40);
        g.drawOval(100, 100, 30, 30);
        g.drawOval(200, 100, 40, 25);
        g.drawLine(20, 140, 200,140);
        g.drawRect(20, 160, 50, 80);
        g.drawRoundRect(110, 160, 100, 100, 25, 18);
    }
}
///
在窗口显示文字用 g.drawString(String, intX, intY)。intX,intY是开始显示的位置。画椭圆用g.drawOval(中心坐标，长轴，短轴)，画直线用g.drawLine(起点，终点)，画矩形用g.drawRect(左上角坐标，X边长，Y边长)。drawRoundRect是圆角矩形，比矩形对两个参数表示圆角的大小。
2 设置颜色和字体
例1中的文字使用默认的字体和大小和默认的黑色，不免单调。使用不同的字体字号和选择不同的颜色是美化网页必不可少的。
设置背景色的是方法继承自Applet的，语法为：
    setBackground(new Color(int,int,int))
即它的参数是一个Color对象句柄。
设置前景色的方法是属于Graphics的，即设置Graphics的绘图色。语法为：
    g.setColor(Color对象);
选择颜色有两种方法，一是直接用颜色值RGB创建Color对象，如：
    Color color = new Color(R,G,B)
另一种是用颜色常量如Color.red, Color.green等。Color类提供了13种颜色常量，由其格式可知它们都是静态的终极的。
