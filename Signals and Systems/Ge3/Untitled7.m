t=0:1:200;
x1=rand(size(t));
subplot(2,1,1)
plot(t,x1),title('rand')
x2=randn(size(t));
subplot(2,1,2)
plot(t,x2),title('randn')