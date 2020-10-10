package br.com.devdojo.error;

public class ResourcesNotFoundDetails {
    private String title;
    private int status;
    private String datail;
    private long timeStamp;
    private String developerMessage;

    private ResourcesNotFoundDetails() {
    }


    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDatail() {
        return datail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String datail;
        private long timeStamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder datail(String datail) {
            this.datail = datail;
            return this;
        }

        public Builder timeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourcesNotFoundDetails build() {
            ResourcesNotFoundDetails resourcesNotFoundDetails = new ResourcesNotFoundDetails();
            resourcesNotFoundDetails.datail = this.datail;
            resourcesNotFoundDetails.title = this.title;
            resourcesNotFoundDetails.developerMessage = this.developerMessage;
            resourcesNotFoundDetails.status = this.status;
            resourcesNotFoundDetails.timeStamp = this.timeStamp;
            return resourcesNotFoundDetails;
        }
    }
}
