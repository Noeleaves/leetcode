class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        if(num2.equals("0") || num1.equals("0")) return "0";
        int[] product = new int[num1.length() + num2.length()];
        StringBuilder ans = new StringBuilder();
            
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // System.out.println(mul % 10);
                // System.out.println("position: "+ (i + j));
                // System.out.println(mul / 10);
                // System.out.println("position: "+ (i + j + 1));
                product[i + j + 1] += mul % 10;
                product[i + j] += mul / 10 + product[i + j + 1] /10;
                product[i + j + 1] = product[i + j + 1] % 10;
            }
        }
        
        for(int k = 0; k < product.length ; k++) {
            if(k == 0 && product[k] == 0) continue;
            ans.append(product[k]);
        }

        
        return ans.toString();
    }
}

43. Multiply Strings

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
   
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
    
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
