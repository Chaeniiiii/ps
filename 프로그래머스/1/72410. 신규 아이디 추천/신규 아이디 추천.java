class Solution {
    
    private static class Id {
        
        String id ;
        
        private Id(String id){
            this.id = id;
        }
        
        private Id toLower(){
            this.id = id.toLowerCase();
            return this;
        }
        
        private Id removeChar(){
            this.id = id.replaceAll("[^a-z0-9\\._-]","");
            return this;
        }
        
        private Id dot(){
            this.id = id.replaceAll("\\.{2,}",".");
            this.id = id.replaceAll("^\\.|\\.$","");
            return this;
        }
        
        private Id putA(){
            if(this.id.equals("")) this.id = "a";
            return this;
        }
        
        private Id cutStr(){
            if(this.id.length() > 15) this.id = id.substring(0,15);
            return this;
        }
        
        private Id setLen(){
            
            while(this.id.length() < 3){
                this.id = this.id + this.id.charAt(this.id.length()-1);
            }
            
            return this;
            
        }
        
        private String getString(){
            return this.id.toString();
        }
        
    }
    
    public String solution(String new_id) {
        
        return new Id(new_id).toLower().removeChar().dot().putA().cutStr().dot().setLen().getString();
        
    }
}