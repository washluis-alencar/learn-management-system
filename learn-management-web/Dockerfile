# Base
FROM node:14-alpine3.14 AS angular-base
LABEL stage=angular-base

WORKDIR /app

# Bundle app files
COPY package.json package.json
RUN npm install

COPY ./ /app/
RUN npm run build

FROM nginx:1.21.6

COPY --from=angular-base /app/dist/learn-management-web /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
