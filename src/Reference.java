import java.util.Stack;

class Reference {

    // declare the member field
    Stack<Integer> stack;
    int numPairs = 0;
    // declare the constructor
    public Reference()
    {
        stack = new Stack<Integer>();
    }


    /*
     * solve   : to compute the result, return the result
     *  Pre-condition : parameter must be of array of integer type
     * Post-condition : return the number of tree pairs that can be swung with
     */
    public int solve(int[] arr) {
        // implementation
        int input;

        for(int i=0; i<arr.length; i++)
        {
            input = arr[i];
            if(stack.isEmpty()) //if stack is empty, just push the input
                stack.push(input);

            else if(!stack.isEmpty())
            {
                //do a while loop to pop all possible top stack element until
                //the top element is bigger than the input
                //or the stack is empty
                while(!stack.isEmpty() && input > stack.peek())
                {
                    stack.pop();
                    numPairs++;
                }

                //if the stack is empty after exiting the while loop
                //push the current element onto the stack
                if(stack.isEmpty())
                    stack.push(input);
                    //this condition applies for two cases:
                    //1. the while loop is never entered because the input is smaller than the top element by default
                    //2. the while loop is exited and the input is pushed onto the non-empty stack with numPairs being incremented
                else if(!stack.isEmpty() && input < stack.peek())
                {
                    stack.push(input);
                    numPairs++;
                }
                //this is the last condition:
                //the input is never pushed if the input is identical to the top element
                //instead we increment the numPairs
                else if(input == stack.peek())
                    numPairs++;

            }

        }
        return numPairs;
    }
}