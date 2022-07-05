FROM jenkins/ssh-agent:alpine
COPY setup.sh root/setup.sh
RUN apk update
RUN rm /usr/glibc-compat/lib/ld-linux-x86-64.so.2 && \
    ln -s ld-2.33.so /usr/glibc-compat/lib/ld-linux-x86-64.so.2
RUN apk add curl
RUN apk add git
RUN apk add jq
RUN chmod 755 root/setup.sh
RUN ./root/setup.sh