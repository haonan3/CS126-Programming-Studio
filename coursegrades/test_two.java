package com.pztuan.entity;

import java.util.List;

public class OtherDetail {

	private int state;
	private List<err> err;
	private OtherDetail2 data;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<err> getErr() {
		return err;
	}

	public void setErr(List<err> err) {
		this.err = err;
	}

	public OtherDetail2 getData() {
		return data;
	}

	public void setData(OtherDetail2 data) {
		this.data = data;
	}

	public class OtherDetail2 {
		private List<partnerteamlist> partnerteamlist;
		private List<liketeamlist> liketeamlist;
		private List<feedbacks> feedbacks;

		public List<liketeamlist> getLiketeamlist() {
			return liketeamlist;
		}

		public void setLiketeamlist(List<liketeamlist> liketeamlist) {
			this.liketeamlist = liketeamlist;
		}

		public List<feedbacks> getFeedbacks() {
			return feedbacks;
		}

		public void setFeedbacks(List<feedbacks> feedbacks) {
			this.feedbacks = feedbacks;
		}

		public class partnerteamlist {
			private int pteamId;
			private String ptitle;
			private Double pteamprice;

			public int getPteamId() {
				return pteamId;
			}

			public void setPteamId(int pteamId) {
				this.pteamId = pteamId;
			}

			public String getPtitle() {
				return ptitle;
			}

			public void setPtitle(String ptitle) {
				this.ptitle = ptitle;
			}

			public Double getPteamprice() {
				return pteamprice;
			}

			public void setPteamprice(Double pteamprice) {
				this.pteamprice = pteamprice;
			}

		}

		public class liketeamlist {
			private int lteamId;
			private String ltitle;
			private String limage;
			private Double lteamprice;
			private Double lmarketprice;

			public int getLteamId() {
				return lteamId;
			}

			public void setLteamId(int lteamId) {
				this.lteamId = lteamId;
			}

			public String getLtitle() {
				return ltitle;
			}

			public void setLtitle(String ltitle) {
				this.ltitle = ltitle;
			}

			public String getLimage() {
				return limage;
			}

			public void setLimage(String limage) {
				this.limage = limage;
			}

			public Double getLteamprice() {
				return lteamprice;
			}

			public void setLteamprice(Double lteamprice) {
				this.lteamprice = lteamprice;
			}

			public Double getLmarketprice() {
				return lmarketprice;
			}

			public void setLmarketprice(Double lmarketprice) {
				this.lmarketprice = lmarketprice;
			}
		}

		public class feedbacks {
			private int totalcount;
			private Double totalscore;
			private List<feedbacklist> feedbacklist;

			public int getTotalcount() {
				return totalcount;
			}

			public void setTotalcount(int totalcount) {
				this.totalcount = totalcount;
			}

			public Double getTotalscore() {
				return totalscore;
			}

			public void setTotalscore(Double totalscore) {
				this.totalscore = totalscore;
			}

			public List<feedbacklist> getFeedbacklist() {
				return feedbacklist;
			}

			public void setFeedbacklist(List<feedbacklist> feedbacklist) {
				this.feedbacklist = feedbacklist;
			}

			public class feedbacklist {
				private String username;
				private String comment;
				private String createtime;
				private Double score;

				public String getUsername() {
					return username;
				}

				public void setUsername(String username) {
					this.username = username;
				}

				public String getComment() {
					return comment;
				}

				public void setComment(String comment) {
					this.comment = comment;
				}

				public String getCreatetime() {
					return createtime;
				}

				public void setCreatetime(String createtime) {
					this.createtime = createtime;
				}

				public Double getScore() {
					return score;
				}

				public void setScore(Double score) {
					this.score = score;
				}

			}
		}

		public List<partnerteamlist> getPartnerteamlist() {
			return partnerteamlist;
		}

		public void setPartnerteamlist(List<partnerteamlist> partnerteamlist) {
			this.partnerteamlist = partnerteamlist;
		}
	}

	public class err {
		private int code;
		private String msg;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
}
