#include <stdio.h>
#include <stdlib.h>

struct Node{

    int data;
    struct Node* next;
};

struct Node* Head;

void createNode(struct Node** Head,int data){

    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->next = NULL;

    if (*Head == NULL)
    {
        node->next = *Head;
        *Head = node;
    }
    
    else{

        struct Node* curr = *Head;

        while (curr->next != NULL)
        {
            curr = curr->next;
        }
        
        curr->next = node;
    }
}

void insertPos(struct Node** Head,int newData,int pos){

    if (pos < 1)
    {
        printf("Wrong pos");
        return;
    }
    
    else{

        struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
        newnode->data = newData;
        newnode->next = NULL;

        if (pos == 1)
        {
            newnode ->next = *Head;
            *Head = newnode;
        }
        else{
            struct Node* curr= *Head;

            for (int i = 0; i < (pos - 2); i++)
            {
                curr = curr->next;
            }
            
            newnode->next = curr->next;
            curr->next = newnode;
        }
    }
}

int main(){

Head = NULL;

FILE* file = fopen("input.txt","r");

    if (file == NULL)
    {
        printf("Error");
        return EXIT_FAILURE;
    }

FILE* printer = fopen("output.txt","w");
    if (printer == NULL)
    {
        printf("Error");
        return EXIT_FAILURE;
    }

int n,pos;
int data;

fscanf(file,"%d %d",&n,&pos);

for (int i = 0; i < n; i++)
{
    fscanf(file,"%d",&data);
    createNode(&Head,data);
}

fclose(file);

int newData;
printf("Enter new data:\n");
scanf("%d",&newData);

insertPos(&Head,newData,pos);

while (Head != NULL)
{
    fprintf(printer,"%d\n",Head->data);
    Head = Head->next;
}

fclose(printer);

    return EXIT_SUCCESS;
}