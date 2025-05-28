class Solution {

    private static class Kakao {
        String id;

        private Kakao(String id) {
            this.id = id;
        }

        private Kakao replaceSmall() {
            this.id = this.id.toLowerCase();
            return this;
        }

        private Kakao removeStr() {
            this.id = this.id.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private Kakao replaceDot() {
            this.id = this.id.replaceAll("\\.{2,}", ".");
            return this;
        }

        private Kakao removeDot() {
            if (!this.id.isEmpty() && this.id.charAt(0) == '.')
                this.id = this.id.substring(1);
            if (!this.id.isEmpty() && this.id.charAt(this.id.length() - 1) == '.')
                this.id = this.id.substring(0, this.id.length() - 1);
            return this;
        }

        private Kakao isNull() {
            if (this.id.isEmpty()) this.id = "a";
            return this;
        }

        private Kakao cutLen() {
            if (this.id.length() >= 16)
                this.id = this.id.substring(0, 15);
            return this;
        }

        private Kakao checkLen() {
            while (this.id.length() < 3)
                this.id += this.id.charAt(this.id.length() - 1);
            return this;
        }

        private String get() {
            return this.id;
        }
    }

    public String solution(String new_id) {
        return new Kakao(new_id)
                .replaceSmall()
                .removeStr()
                .replaceDot()
                .removeDot()
                .isNull()
                .cutLen()
                .removeDot()
                .checkLen()
                .get();  
    }
}
