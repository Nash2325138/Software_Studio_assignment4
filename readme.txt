1. Human-OCR:
	嗯總之就是東查西查瘋狂查，總算是兜出來一個符合規格的形式。
	是否採用使用者的輸入機制很簡單，每次都把 known_word 與 unknown_word 以一左一右的形式隨機擺放。
	若 known_word 答對則視 unknown_word 也正確，比較特別是有懲罰狀況，就是當 known_word 輸入錯誤時，
	將會重複1～3次（隨機）的驗證期，再這幾次中兩個降下來的自都會是 known_word(使用者無法得知此狀況)，
	必須連續輸入正確直到驗證期結束（此期間不會採記任何答案），才會在回到 known_word 與 unknown_word 各一
	個的正常狀況。直到每次答對+4分到100後結束。
2. Reassembling original paragraphs
	這個東西簡單很多，只要把當初有輸出好的檔讀進來，把數字截出來，然後用類似 counting sort 的概念把每個 known_word
	填到對應的二維陣列位置中，然後再按照順序印，沒有的就只印底線。