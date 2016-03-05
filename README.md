# HeapSort




This is an implementation of an HeapSort based on one dimentional Partial Order Binary Tree in Java and C++. 
The program takes three arguments																																		
																												
	1)	input file (inFile.txt)																						
	2)  debug file (debugFile.txt)																																	
	3)  output file (outFil.txt)																																				
																																
The program takes data from an input file (inFile.txt) and Build a Heap. Then it deletes the root and rearranges the Heap to keep order,
resulting in a Sorted list of numbers being outputed in output file (outFile.txt). In addition as the Heap being built or deleted 
it outputs the the present Heap in another output file (debugFile.txt) 

The command to run n java is as follows
		
			java HeapSort inFile.txt debugFile.txt outFile.txt               





Step 1:  
          -open the input file;  
          -read and count the number of date item in the  input file                                        
          -close the file                                                     
          -dynamically allocate the 1-D array of the size count+1                                       
          -and initallize heapAry[0] to 0. Remember, heapAry[1] is the front.                                               
 
step 2: 																																																								
        -call buildHeap (see algorithm below)                                                 
        -open the file for the second time                                              
        -Now open two different file (inFile and defug File)                                      
        -Pass the inFile as a String and pass the debug file as reference                                         
        -insertOneDataItem (data)  and bubble up                                  
        -print the Heap to the debudFile                                      
        -Repeat until the inFile is empty                                   
        -close the inFile                                 
                                                                                              
step 3: 																																										
        -call deleteHeap (see algorithm below)                                                                
        -open outFile (debug file is already open)                              
        -deleteRoot() and bubble down                                       
        -print the root to the outFile and print the Heap to the outFile                                            
        -Repeat untill the Heap is empty                                                                    
        -close both outFile and debugFile                                           
 
 
