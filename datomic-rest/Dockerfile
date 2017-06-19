FROM clojure:lein-2.6.1-alpine

MAINTAINER Luiz Borba <lborba@gmail.com>

ENV DATOMIC_VERSION 0.9.5561.50

ADD https://my.datomic.com/downloads/free/${DATOMIC_VERSION} /tmp/datomic.zip

RUN unzip /tmp/datomic.zip && rm /tmp/datomic.zip

WORKDIR datomic-free-${DATOMIC_VERSION}

EXPOSE 8888

CMD ["bin/rest", "-p", "8888", "-o", "/'*'/", "db", "datomic:mem://"]
