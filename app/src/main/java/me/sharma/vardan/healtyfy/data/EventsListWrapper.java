package me.sharma.vardan.healtyfy.data;

import java.util.List;

/**
 * Created by vardaan sharma on 19/3/16.
 */
public class EventsListWrapper {
    private List<ResponseBean> response;

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        private String status;
        private String challenge_type;
        private String start_timestamp;
        private String description;
        private String end_date;
        private String title;
        private String url;
        private boolean is_hackerearth;
        private String end_tz;
        private String end_utc_tz;
        private String subscribe;
        private boolean college;
        private String end_time;
        private String time;
        private String date;
        private String start_utc_tz;
        private String start_tz;
        private String end_timestamp;
        private String thumbnail;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getChallenge_type() {
            return challenge_type;
        }

        public void setChallenge_type(String challenge_type) {
            this.challenge_type = challenge_type;
        }

        public String getStart_timestamp() {
            return start_timestamp;
        }

        public void setStart_timestamp(String start_timestamp) {
            this.start_timestamp = start_timestamp;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isIs_hackerearth() {
            return is_hackerearth;
        }

        public void setIs_hackerearth(boolean is_hackerearth) {
            this.is_hackerearth = is_hackerearth;
        }

        public String getEnd_tz() {
            return end_tz;
        }

        public void setEnd_tz(String end_tz) {
            this.end_tz = end_tz;
        }

        public String getEnd_utc_tz() {
            return end_utc_tz;
        }

        public void setEnd_utc_tz(String end_utc_tz) {
            this.end_utc_tz = end_utc_tz;
        }

        public String getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(String subscribe) {
            this.subscribe = subscribe;
        }

        public boolean isCollege() {
            return college;
        }

        public void setCollege(boolean college) {
            this.college = college;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStart_utc_tz() {
            return start_utc_tz;
        }

        public void setStart_utc_tz(String start_utc_tz) {
            this.start_utc_tz = start_utc_tz;
        }

        public String getStart_tz() {
            return start_tz;
        }

        public void setStart_tz(String start_tz) {
            this.start_tz = start_tz;
        }

        public String getEnd_timestamp() {
            return end_timestamp;
        }

        public void setEnd_timestamp(String end_timestamp) {
            this.end_timestamp = end_timestamp;
        }
    }
}
