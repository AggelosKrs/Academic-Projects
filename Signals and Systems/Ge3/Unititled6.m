t=-5:0.1:5;
x1=t.^2.*exp(1.^(3.*t));
subplot(2,2,1)
plot(t,x1)
x2= t.^2.*exp(1.^(3.*t))+(-t.^2.*exp(1.^(3.*(-t))))/2;
subplot(2,2,2) 
plot(t,x2)
x3= t.^2.*exp(1.^(3.*t))-((-t).^2.*exp(1.^(3.*(-t))))/2;
subplot(2,2,3)
plot(t,x3)
x4=x2+x3;
subplot(2,2,4)
plot(t,x4)
