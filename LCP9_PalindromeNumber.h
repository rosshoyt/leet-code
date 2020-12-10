// leetcode problem #9 - Palindrome Number  
class Solution {
public:
    typedef std::vector<int> IntArray;
    
    bool isPalindrome(int x) {
        if(x < 0) {
            return false;
        } 
        else{
            auto digits = getDigitList(x);
            int size = digits.size();
            for(int i = 0; i < size; ++i){
                if(digits[i] != digits[size-1-i])
                    return false;
            }
            return true;
        }
    }

    IntArray getDigitList(int n){
        IntArray digits;   
        int value = 0;
        long place = 10, prevPlace = 1;     
        do{
            int remainder = n % place; 
            value = remainder / prevPlace;
            digits.push_back(value);
            prevPlace = place;
            place *= 10;
            n -= remainder;
            //cout << value << ',';
        } while(n > 0);
        return digits;
    }
    
};