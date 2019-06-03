package com.tongdada.sample;

import java.util.List;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:07
 * @change
 */
public class SampleBean {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * displaySeq : 99
         * paymentCode : 0001
         * paymentName : 保百会员卡
         * interFaceCategoryCode : 2007
         * paymentIcon : null
         * paymentIconS : iVBORw0KGgoAAAANSUhEUgAAADMAAAAnCAYAAACi5nCnAAAJkElEQVRYhdVZfWyVVxn/nffeXrp+8CGlJbAW17lpiWSQDv6gNCaORbNidDEu0cjEjASzPzCGj2FUUogZSdVEE0dijP/4z1y6zC1RQjKpbhMJjM6KNLMtJYx+UD5aWFmB3t7e43vOe57nPOe9tzMk/rPT3t7343w8v+f7eaoqGlZrpRS01ji69QFAAdCw3yr+0fYmeWbmqEiBH5l7M9/+Ac+zf8wz7TaiBRBzNR/C55V8857mnIjPDN7xcQp2RhRF7iA6xBHvqXZ0KAuQ5ir7iZhWRZQQECKcwcbMKWo3T/F5vG/qfMEBC0KLucGP2z/iixiQJJRBaEeMO99yhk8SkktzXgLXYM6SFtjHRR0QymcxYxHSpBIGa1105Gl3n3xH5mJ+ft5+7CSlAjEz17S/BwQn6ZmTJB0eqKgiKWuikCXrpeyBS80M1Ip56PZOqRurmUp0JuBmwDWyoRgwc1dLopP7YrHI9pUmzO6vIlYPKQHiNgTAAEFqLyWRONqyhjBDgCUCcgNvicpxQmuvFsRJUpmAw85eFLxKEWier1hkkiISh1dtrdLkuClFiI3s3lnaKpPJJBxSwnB1GfEzXB2810QwEWKk5KRIzLDvVdrGQk5rOkj7Xb1fUd4UlGcE0ZA1EjFqRtxOEHsj9naQ9pfEIc3S0G7jiqpaLG/6HOo/sx6r121B7YpG1NStgo7tcvraCGYmx3C57y1cG3wPN8eHUMjfS3nO1DmsaSU+27tsc51b+SDHmZeeqPSrHXK2j0BFBWihx5mKCqxpfRI1j7bjs49/AUuW1YUxKMWEiZGLGO47ienzb2Ji4CyK83NSVF5a8qwyIIkG683YXhTtRQFPch7sqsl25IFRJov1X30e06va8NyeQ3j5D92Ym5srC8SMmdu38fNfHcXO/S9i7pEvxxJsizeLQs/GQDzl7FmFtiYu3oEhot2FA+U5ZEUo/b/Qc7POAHksBlLRvAWdnT/F4MAAxsbHMR84lXDkY6DDFy5gaGgIXb88ikeffgEtW78Vn5NhOtj+pN06GpRzEIlNJi8z2dolncT9juYs0uIMHUBKzsqoVg4bvvY8lq9/Cj/68UH8/eRJNDc348CBA2hqagq4LEdu0SJUxp+enh6MjIygUJjH09/9PjJ6Djcu9XvVlt6Ob3xGIr8zUXVtp7kx3uyph7JepYSfT4zMu2nmTvzz6Y1fQkvH97Bn3wG8/sYbyOfzOHToELZt25Z4yAWGcToPxaArYjs7duwY/n3+PEbHxvGVZ76DyaEzmJ35MGBaYC/str2bTzDULO6kOYlkwBO1dM1KSMw9L2YqMJp9GHt+8iJOnDiBhoYG7N27F/v27ftYIDSy2Sw2b95sr3t7e3H69Gn88/x/sLrhU6i4c90YAyiuRYryR8WJp0qBsmpm6YsfbHu4QoD3uVTgmVnsGpcm8/jZK+/g0uURtLW14fDhw9ixY4cl8n7Ghg0bUF9fj6tXr+LUqVPoGxpFa2MlKrPCIcjwJLRHCQ5nVFVNJ3Gxw4BxxpQsAqceIXeSP70jM7iSr8Lu3btx5MgRtLa2YlFsB/c7KisrsW7dOnR0dFiJnjpzFmuWZLFycRasDo6ugMkgMM4EqJ4xn19/MReglmm8Td0j/87cZ9d/E1uf2YkHGxvjd9F9gyg3TMI7EHvDv3X/BrmhYyLLLh8wpaOIZEoeoCbvpR0QUXPYqxjY17/9HBrXrPm/ATHDSGbt2rX4xrM7LYU+l1MljkDmfWbYdIaSTUopPFonvihMGin9ro5TlHKju7sbx48fx71796wKmeCZy+XsvfFexuOZ52Zs2rQJu3btKtljeVOLA5HKONwzm4C6TCXBEIMxnCBAAjNMEap5IcIEkbxdsRBf5EoI6erqQn9/P5YtXeqr2NQwAXVqagqvv/Yatm/fjqqqquB9sZBnFbf0pVSc6ipLjmN2VqbzCZ3KZS4idVc6yFApMt++MYZlqx8pS2x7ezte2L8fNYbIdBkdj1vT0zh48CAuDA6WXT81MpBciGWUCFtgQJCUGpqyXHwB/NChABdeQR3hi6WZySsLgjGu9vGNG7G4pqbs+8mbN1FXV4fhBcB8dH1cOCKh5kHqL7L9mOGRUQOjakk9E5aoXC3Kak+M0XPvlCXEdkpIgkbNyn3id4VCoex6My6e/lMQ18JegyhXVJKMGrDcAyCkkiC7jEQp022Xtk4MnsXdD2+UUuJqG2hd+k6MhexpanQw3vs9oRE68KTgugtBU8SCoeIMRKciEC62OOJVSsS3xi5iMk4KS7A4Jvwvl11cIKsefOtV5GemgxCR9Ba0UPsEFPcv4BoaZvjujAdEdXwiMRmJ3Zr8XZz78+9w59a1gJhAzRYYZptsmfxt6oP38cHZN+NCrcAhgHpjSY+u1BTIbiKKMUlKIyOSmOxufOvINycmBt7F27/9IQqzd8Vaf8BCw+yUrnfMHv/4/WF8dGO8pMXF2kKeMVX92r4ZcbKkOKMj+dq3h/iQ+MtwcPTc2zjzSpcre935Sn0sGPMmI9TQAPnr0R/EttIbry861slyEp4W0bvjVCf+temt0TvrBIKs2Lk+YXykr0kA1UkUdmve/8vLNhFtefJZu3Z4eBh/jANideyazd6R03FqoNyOy+bRsTFLzGSsWv969RcxkHeZWUEDkUpnOq8ca8wvJZpmJA2NwG2Bo1bKxwcsdlyLoiwW1zeip/8qjvWNY2a2iAeqq5GfnbVqbEBQamMA1mbz2NJciycea8KdqQkEuRgB4Wjv+w5Uz8i0y14aMOTRXtpa6UWawpNISnRqxDM7RTwvxhwsZHKoXdWCFZ9vR+XSlahe0WTV8M71y7gXO4yr53owc2UIuWieYrjnMGTyS4E7bCtRgSgdAKtZIF7vjYWehtGfHEe5EUUaOT2L2dG+WJX6RPQO5y2KJLdVWafhm4cQvXAXW6gX4PK2iLgqs+aSUU4S8AdTPRRUo0ynB8I9Zk1pu8yxnF3rcO80SRwqOGlW7HXZm1F7lg8SkVd2/JljxTCf881zJwGZ27lhGZYqIyieJfszGh/zWNW9NLxdeSdhtCsiFUtUJq0KSdrAUZeIQCJa7g9wVhsFToJUhNq3C3lq6eq5UUHPNAEv7QyRt02wFn0T0FHDnPZtHOnBPCf4ECFN6cYZkKZ/DnnUpBq+/ert1M8nlXbGL/d3Z9O/TxKskU9n0sbNQ3s6OJ0gQOJb04G6WLqHbFMBgptlgiKpHauTZHAI3Bq+8kzmnpBpD+2sv4BP8mBvRmXAJ3n8F5kxUz+mmEX5AAAAAElFTkSuQmCC
         * imageType : .png
         * isCutPoints : 1
         * sytdisplaySeq : 0
         */

        private String displaySeq;
        private String paymentCode;
        private String paymentName;
        private String interFaceCategoryCode;
        private Object paymentIcon;
        private String paymentIconS;
        private String imageType;
        private String isCutPoints;
        private String sytdisplaySeq;

        public String getDisplaySeq() {
            return displaySeq;
        }

        public void setDisplaySeq(String displaySeq) {
            this.displaySeq = displaySeq;
        }

        public String getPaymentCode() {
            return paymentCode;
        }

        public void setPaymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
        }

        public String getPaymentName() {
            return paymentName;
        }

        public void setPaymentName(String paymentName) {
            this.paymentName = paymentName;
        }

        public String getInterFaceCategoryCode() {
            return interFaceCategoryCode;
        }

        public void setInterFaceCategoryCode(String interFaceCategoryCode) {
            this.interFaceCategoryCode = interFaceCategoryCode;
        }

        public Object getPaymentIcon() {
            return paymentIcon;
        }

        public void setPaymentIcon(Object paymentIcon) {
            this.paymentIcon = paymentIcon;
        }

        public String getPaymentIconS() {
            return paymentIconS;
        }

        public void setPaymentIconS(String paymentIconS) {
            this.paymentIconS = paymentIconS;
        }

        public String getImageType() {
            return imageType;
        }

        public void setImageType(String imageType) {
            this.imageType = imageType;
        }

        public String getIsCutPoints() {
            return isCutPoints;
        }

        public void setIsCutPoints(String isCutPoints) {
            this.isCutPoints = isCutPoints;
        }

        public String getSytdisplaySeq() {
            return sytdisplaySeq;
        }

        public void setSytdisplaySeq(String sytdisplaySeq) {
            this.sytdisplaySeq = sytdisplaySeq;
        }
    }
}
