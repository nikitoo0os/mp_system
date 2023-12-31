FROM node:16-alpine

WORKDIR /frontend/mp_front

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD npm run dev

FROM node:18-alpine AS deps
RUN apk add --no-cache libc6-compat
WORKDIR /frontend/mp_front

COPY package.json package-lock.json ./
RUN  npm install --production

FROM node:18-alpine AS builder
WORKDIR /frontend/mp_front
COPY --from=deps /frontend/mp_front/node_modules ./node_modules
COPY . .

ENV NEXT_TELEMETRY_DISABLED 1

RUN npm run build

FROM node:18-alpine AS runner
WORKDIR /app

ENV NODE_ENV production
ENV NEXT_TELEMETRY_DISABLED 1

RUN addgroup --system --gid 1001 nodejs
RUN adduser --system --uid 1001 nextjs

COPY --from=builder --chown=nextjs:nodejs /app/.next ./.next
COPY --from=builder /frontend/mp_front/node_modules ./node_modules
COPY --from=builder /frontend/mp_front/package.json ./package.json

USER nextjs

EXPOSE 3000

ENV PORT 3000

CMD ["npm", "start"]
