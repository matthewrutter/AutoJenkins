FROM wernight/ngrok:latest
RUN apk update
RUN rm /usr/glibc-compat/lib/ld-linux-x86-64.so.2 && \
    ln -s ld-2.33.so /usr/glibc-compat/lib/ld-linux-x86-64.so.2
RUN apk add curl
