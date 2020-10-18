package vo;

public class Download {
	 	private int id;//表示
	    private String  name;//名称
	    private String  path;//存放路径
	    private String  description;//描述
	    private String  size;//文件大小
	    private int  star;//星级
	    private String  image;//图片路径
		@Override
		public String toString() {
			return "Download [id=" + id + ", name=" + name + ", path=" + path + ", description=" + description + ", size="
					+ size + ", star=" + star + ", image=" + image + "]";
		}
		public Download(){
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public int getStar() {
			return star;
		}
		public void setStar(int star) {
			this.star = star;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}

}
