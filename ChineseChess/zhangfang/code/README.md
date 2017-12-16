
### 文件说明：  
ChessBoard.java: 控件的添加，棋盘使用Graphics绘制   
ChessPiece.java: 棋子使用的是图片，该类对棋子位置进行初始化   
ChessRule.java: 对棋子移动和吃棋规则的制定  
MouseClickedEvent.java: 鼠标点击事件的实现  
ChessMain.java: 主文件,游戏开始的入口

### 遇到的问题以及解决方法：  
1. 棋盘用图片：  
坐标位置不好控制 —— 采用Graphics绘制棋盘, 并添加到Container中（自定义了一个paintChessBoard方法用于绘制棋盘）, 棋子棋盘坐标都是相对于Container的，在设置规则的时候比较好控制。  
2. 规则的制定：  
对游戏规则的不熟悉 —— 查看象棋游戏规则  
3. 鼠标点击事件：  
由于鼠标点击事件是单独写的，传参问题 —— 重载mouseClicked方法；  
区分是移动棋子还是吃棋子 —— 通过一个boolean变量isClick来判断；  
为了判别棋子是否被点击 —— 设置线程，棋子第一次被点击时，棋子闪烁；  
4. 线程：  
本来想自定义一个线程方法，使代码更清晰，但传参遇到问题 —— 新建线程时，直接重写run方法，有待进一步解决
