T=2/5;
t=0:0.01:3*T-0.01;
x=2*cos(5*pi*t+pi/4);
subplot(2,1,1)
plot(t,x)
T1=2/3;
t1=0:0.01:3*T-0.01;
y=sin(3*pi*t1);
subplot(2,1,2)
plot(t1,y)

