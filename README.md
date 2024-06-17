# 2024-pd2-FinalProject - 媒體播放器

# 簡介
- 一個mp3歌曲播放器，實現歌曲新增、移動、播放等功能，以及歌曲清單的管理
  
- 在window 64位元環境下執行，使用java語言編寫
  
# 運行需求
- maven ("Maven for java" extension in VS code)
- (請手動下載) ChromeDriver 版本為當前chrome的版本
- (Maven自動下載) Selenium / Jlayer 等函式庫

# 執行
- 將整個專案放到IDE裡，執行Main.java
  
# 組員及分工
- F74126254 曾翊庭 - 儲存
- F74126270 潘亮銓 - 銜接GUI和儲存庫的功能、播放器主體
- F74122242 許成豪 - GUI介面

![image](https://github.com/penguiney/2024-pd2-FinalProject/blob/f325e4843a7cff0ce86fc1f0e6423c0758ae296c/picture/finalproject%E5%88%9D%E5%A7%8B%E5%88%86%E5%B7%A5.png)
![image](https://github.com/penguiney/2024-pd2-FinalProject/blob/d7cde1b5764f7c747068c975a939d667fa7be957/picture/finalproject%E6%9C%80%E7%B5%82%E5%88%86%E5%B7%A5.jpg)

# 專案管理
- 為了引入函式庫，並方便檔案管理 > 使用Maven來管理專案
- 在共同編輯時，能更方便的整合程式碼，並儲存歷史紀錄 > 使用Git和Github以便版本控制

# 困難
## 分工合作
- 不同組員之間的程式碼如何合作

## 程式碼
- 視窗之間的協作
- player卡程序

# 尚未實現的功能
- 播放器的暫停
  - 我們使用的播放器是AdvancedPlayer，在AdvancedPlayer中的sop method無法實現暫停功能，他只能停止播放，但不會記錄當前播放的幀的位置。
- 播放器的關閉
  - 如果直接關閉播放器而未停止音樂，播放器FUI會關閉但音樂仍在播放
  - 或者關閉播放器會直接關閉所有程式
