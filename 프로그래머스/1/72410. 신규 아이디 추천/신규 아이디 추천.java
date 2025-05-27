class Solution {
    
    private static class NewId {
        
        String id;
        
        private NewId(String id){
            this.id = id;
        }

        //1단계                
        private NewId replaceSmall(){
            this.id = id.toLowerCase();
            return this;
        }
        
        //2단계
        private NewId replaceStr(){
            this.id = id.replaceAll("[^a-z0-9\\._-]","");
            return this;
        }
        
        //3-4단계
        private NewId dot(){
            //3단계
            this.id = id.replaceAll("[.]{2,}",".");
            //4단계
            this.id = this.id.replaceAll("^\\.|\\.$", "");
            
            return this;
        }
        
        //5단계
        private NewId putA(){
            if(this.id.equals("")){
                this.id+="a";
            }
            return this;
        }
        
        //6단계
        private NewId cutStr(){
            if(this.id.length() > 15) {
                this.id = id.substring(0,15);
            }
            return this;
        }
        
        //7단계
        private NewId attachChar(){
            
            while(this.id.length() < 3){
                
                this.id += this.id.charAt(this.id.length()-1);
                
            }
            
            return this;
            
        }
        
        private String getString(){
            return this.id.toString();
        }
        
    }
    
    public String solution(String new_id) {
        
        String id = new NewId(new_id)
            .replaceSmall()
            .replaceStr()
            .dot()
            .putA()
            .cutStr()
            .dot()
            .attachChar()
            .getString();
        
        return id;
    }
}