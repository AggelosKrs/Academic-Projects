subplot(2,2,1)
t=-10:.1:10;
u1=heaviside(t);
u2=heaviside(t-4);
u=u1-u2;
plot(t,u);
title('x(t)')
ylim([-0.3 1.3])

subplot(2,2,2)
u1=heaviside(-t);
u2=heaviside(t-4);
u=u1-u2;
plot(t,u,'r');
title('x(t-t)')
ylim([-0.3 1.3])

subplot(2,2,3)
u1=heaviside(t/3);
u2=heaviside(t/3-4);
u=u1-u2;
plot(t,u,'k');
title('x(t/3)')
ylim([-0.3 1.3])

subplot(2,2,4)
u1=heaviside(2*t);
u2=heaviside(2*t-4);
u=u1-u2;
subplot(3,2,6)
plot(t,u,'g');
title('x(2*t)')
ylim([-0.3 1.3])