from helpers import alphabet_position, rotate_character                         
def encrypt(text,key):
    char = 0 
    mess = ''
    

    for letter in range(len(text)):      

        letter = text[letter]
        if letter.isalpha() == False:
            mess += letter
            continue
        pos = alphabet_position(key[char%len(key)])
       
        
        mess += rotate_character(letter,pos)
        
        char += 1
    return mess 
                                

def main():
    text = input("What is your message? ")
    key = input("What is your encryption key? ")
       
    
if __name__ == "__main__": 
    main()
	  
	  

	  