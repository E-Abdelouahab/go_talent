package app.modeles;

import java.time.LocalDateTime;


	
	
	public class participation {
		private long iduser;
		private Long categoryID;
		private String descParti;
		private String timeStart;
		private  String timeEnd;
		private String attachedFile;
		private boolean isAccepted;
		

	



		public long getIduser() {
			return iduser;
		}






		public void setIduser(long iduser) {
			this.iduser = iduser;
		}






		public Long getCategoryID() {
			return categoryID;
		}






		public void setCategoryID(Long categoryID) {
			this.categoryID = categoryID;
		}






		public String getDescParti() {
			return descParti;
		}






		public void setDescParti(String descParti) {
			this.descParti = descParti;
		}



		public String getTimeStart() {
			return timeStart;
		}






		public void setTimeStart(String timeStart) {
			this.timeStart = timeStart;
		}






		public String getTimeEnd() {
			return timeEnd;
		}






		public void setTimeEnd(String timeEnd) {
			this.timeEnd = timeEnd;
		}






		public String getAttachedFile() {
			return attachedFile;
		}






		public void setAttachedFile(String attachedFile) {
			this.attachedFile = attachedFile;
		}






		public boolean isAccepted() {
			return isAccepted;
		}






		public void setAccepted(boolean isAccepted) {
			this.isAccepted = isAccepted;
		}






		@Override
		public String toString() {
			return "ParticipationModels [userID=" + iduser + ", categoryID=" + categoryID + ", descParti=" + descParti
					+ ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", attachedFile=" + attachedFile
					+ ", isAccepted=" + isAccepted + "]";
		}
	}

