存放自定义字体类

  //关于Font类
  
  
  java.awt.Font 
  设计字体显示效果 Font mf = new Font(String 字体，int 风格，int 字号);
  字体：TimesRoman, Courier, Arial等 
  风格：三个常量 lFont.PLAIN, Font.BOLD, Font.ITALIC 字号：字的大小（磅数） 
  设置组件当前使用的字体：setFont(Font fn)
  获取组件当前使用的字体：getFont()  int i= font.stringWidth（String str）；
