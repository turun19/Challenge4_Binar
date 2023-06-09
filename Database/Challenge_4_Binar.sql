PGDMP     +    3                {            Challenge_4    14.7    14.7                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16411    Challenge_4    DATABASE     m   CREATE DATABASE "Challenge_4" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Indonesia.1252';
    DROP DATABASE "Challenge_4";
                postgres    false            �            1259    16419    films    TABLE     �   CREATE TABLE public.films (
    film_code integer NOT NULL,
    film_name character varying NOT NULL,
    sedang_tayang_atau_tidak character varying NOT NULL
);
    DROP TABLE public.films;
       public         heap    postgres    false            �            1259    16426 	   schedules    TABLE       CREATE TABLE public.schedules (
    schedule_id integer NOT NULL,
    film_code integer NOT NULL,
    tanggal_tayang date NOT NULL,
    jam_mulai character varying NOT NULL,
    jam_selesai character varying NOT NULL,
    harga_tiket character varying NOT NULL
);
    DROP TABLE public.schedules;
       public         heap    postgres    false            �            1259    16438    seats    TABLE     l   CREATE TABLE public.seats (
    studio_name character varying NOT NULL,
    nomor_kursi integer NOT NULL
);
    DROP TABLE public.seats;
       public         heap    postgres    false            �            1259    16412    users    TABLE     �   CREATE TABLE public.users (
    username character varying(30) NOT NULL,
    email_address character varying(50) NOT NULL,
    password character varying(50) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �          0    16419    films 
   TABLE DATA           O   COPY public.films (film_code, film_name, sedang_tayang_atau_tidak) FROM stdin;
    public          postgres    false    210   �       �          0    16426 	   schedules 
   TABLE DATA           p   COPY public.schedules (schedule_id, film_code, tanggal_tayang, jam_mulai, jam_selesai, harga_tiket) FROM stdin;
    public          postgres    false    211   �                  0    16438    seats 
   TABLE DATA           9   COPY public.seats (studio_name, nomor_kursi) FROM stdin;
    public          postgres    false    212   Q       �          0    16412    users 
   TABLE DATA           B   COPY public.users (username, email_address, password) FROM stdin;
    public          postgres    false    209   n       l           2606    16425    films films_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.films
    ADD CONSTRAINT films_pkey PRIMARY KEY (film_code);
 :   ALTER TABLE ONLY public.films DROP CONSTRAINT films_pkey;
       public            postgres    false    210            n           2606    16432    schedules schedules_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.schedules
    ADD CONSTRAINT schedules_pkey PRIMARY KEY (schedule_id);
 B   ALTER TABLE ONLY public.schedules DROP CONSTRAINT schedules_pkey;
       public            postgres    false    211            p           2606    16444    seats seats_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.seats
    ADD CONSTRAINT seats_pkey PRIMARY KEY (studio_name, nomor_kursi);
 :   ALTER TABLE ONLY public.seats DROP CONSTRAINT seats_pkey;
       public            postgres    false    212    212            h           2606    16418    users users_email_address_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_address_key UNIQUE (email_address);
 G   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_address_key;
       public            postgres    false    209            j           2606    16416    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public            postgres    false    209            q           2606    16433 "   schedules schedules_film_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedules
    ADD CONSTRAINT schedules_film_code_fkey FOREIGN KEY (film_code) REFERENCES public.films(film_code);
 L   ALTER TABLE ONLY public.schedules DROP CONSTRAINT schedules_film_code_fkey;
       public          postgres    false    211    210    3180            �   W   x�34004�)J��S�Wp*-N��NMI�KWI�R\�@%Ɯ�%�E%
�X$M8�J|�C2S���9��:�t��qqq ��$�      �   K   x�Eʱ� D������b��?G�Eh~��(��&�7�Fs��HX� ��TP��Y�_8�O�����<�             x������ � �      �   [   x�+)-*�3�44�,���s3s���s�bF�\PI�"L%P�P>`�1 �����+��62Ⅎ��-���T��c�361����� >�B     