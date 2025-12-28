t1=-3:0.1:-1;
t2=-1:0.1:0;
t3=0:0.1:3;
x1=zeros(size(t1));
x2=cos((pi*t2)/2);
x3=exp(-t3);
x= [x1 x2 x3];
t= [t1 t2 t3];
plot(t,x)
