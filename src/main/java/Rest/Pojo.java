package Rest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Pojo {

        private Integer charId;
        private String name;
        private String birthday;
        private List<String> occupation = null;
        private String img;
        private String status;
        private String nickname;
        private List<Integer> appearance = null;
        private String portrayed;
        private String category;
        private List<Object> betterCallSaulAppearance = null;
        private Map<String, Object> additionalProperties = new HashMap<>();

        public Integer getCharId() {
            return charId;
        }

        public void setCharId(Integer charId) {
            this.charId = charId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public List<String> getOccupation() {
            return occupation;
        }

        public void setOccupation(List<String> occupation) {
            this.occupation = occupation;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public List<Integer> getAppearance() {
            return appearance;
        }

        public void setAppearance(List<Integer> appearance) {
            this.appearance = appearance;
        }

        public String getPortrayed() {
            return portrayed;
        }

        public void setPortrayed(String portrayed) {
            this.portrayed = portrayed;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<Object> getBetterCallSaulAppearance() {
            return betterCallSaulAppearance;
        }

        public void setBetterCallSaulAppearance(List<Object> betterCallSaulAppearance) {
            this.betterCallSaulAppearance = betterCallSaulAppearance;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

