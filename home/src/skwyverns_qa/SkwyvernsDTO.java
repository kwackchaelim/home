package skwyverns_qa;

public class SkwyvernsDTO {
	
	// set, get에서 사용하는 필드 정의
		private int id;
		private String title;
		private String name;
		private String memo;
		private String searchName;
		
		public String getSearchName() {
			return searchName;
		}
		public void setSearchName(String searchName) {
			this.searchName = searchName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
}
