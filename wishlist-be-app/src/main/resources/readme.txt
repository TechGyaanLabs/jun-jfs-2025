Wishlist app — Requirements (only User and WlItem)

Clear, minimal spec for a Wishlist app that only contains User and WlItem (wishlist item). Covers functional & non-functional requirements, data model, DB schema, REST API, validation, UI screens, acceptance criteria, security, testing and sample payloads.

1. Overview

A simple personal wishlist service where authenticated users can create and manage their wishlist items. Each item (WlItem) belongs to exactly one user. No tags, shares, or other entities — minimal surface area.

2. Actors

User — registers, logs in, manages their items.

3. Key features (functional)

User registration & login (email + password).

CRUD for WlItem (create, read, update, soft-delete).

List user’s items with paging, sorting and simple search by title/description.

Mark item status (active, purchased, removed).

Export items as CSV/JSON (optional).

Soft delete (so items can be recovered or audited).


CREATE TABLE users (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  email TEXT NOT NULL UNIQUE,
  password_hash TEXT NOT NULL,
  display_name TEXT,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
  last_login_at TIMESTAMP WITH TIME ZONE
);

CREATE TYPE item_status AS ENUM ('active','purchased','removed');

CREATE TABLE wl_items (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  title TEXT NOT NULL,
  description TEXT,
  link TEXT,
  desired_by DATE,
  status item_status NOT NULL DEFAULT 'active',
  priority SMALLINT DEFAULT 0,
  image_url TEXT,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
  updated_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
  deleted_at TIMESTAMP WITH TIME ZONE
);


liquibase: script
Develop all api => User register (How to do password encryption)
openapi documentation (Test your apis)

Every request you send username as query param

Create custom exception handle those exception. @Controller Advice