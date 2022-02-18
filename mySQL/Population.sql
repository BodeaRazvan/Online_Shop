use OnlineShop;

Insert into Users(username,password,role) values 
('client1','client','Client'),
('client2','client','Client'),
('client3','client','Client'),
('Gheorghe65','gheorghe65','Admin'),
('admin','admin','Admin'),
('worker','worker','Worker');



-- description e varchar(600) not null
-- pic1, pic2 and pic3 sunt varchar(200)
-- pic1 e not null, celelalte pot fi

-- Recomand ca mere sa fie aduagat manual, altfel e probabil ca id-ul sa nu se potriveasca
-- 1
Insert into Products(name,price,description ,pic1,pic2,pic3) values
('Mere',5.0,'Healthy','https://www.auchan.ro/public/images/h2e/h65/h00/mere-rosii-2-kg-8904758394910.jpg','https://www.cora.ro/images/products/1809111/gallery/1809111_hd_1.jpg','http://storage0.dms.mpinteractiv.ro/media/1/1481/25566/17510001/1/04-apples.jpg');
-- 2
Insert into Products(name,price,description ,pic1,pic2) values
('LEGO Star Wars Millenium Falcon', 3999.99,'7541 Pieces and 7 Minifigs', 'https://mcdn.elefant.ro/mnresize/1500/1500/is/product-images/jucarii/fd329539/c06a/44e4/98a1/995cf80d5ffc/fd329539-c06a-44e4-98a1-995cf80d5ffc_3.jpg','https://brickdepot.ro/bmz_cache/d/d2a008765ef3154750ad0d3de6ec3834.image.484x350.jpg');
-- 3
Insert into Products(name,price,description,pic1) value
('PS5',5499.0,'Better than PS4','https://s13emagst.akamaized.net/products/32502/32501277/images/res_d5266fea2bd1d275a3928985e005cba0.jpg');
-- 4
Insert into Products(name,price,description ,pic1,pic2) values
('Pere',6.0,'Also healthy','https://static4.libertatea.ro/wp-content/uploads/2021/04/pere-williams.jpg','https://doc.ro/uploads/photos//cache/pere-benefcii-vitamine-recomandari.jpg');
-- 5
Insert into Products(name,price,description ,pic1,pic2) values
('Haslab TF Unicron',3600.0,'He Big','https://cdn.shopify.com/s/files/1/0169/6995/7440/products/E6830_Transformers_War_For_Cybertron_Unicron_10_2000x.jpg?v=1570035392','https://cdn.shopify.com/s/files/1/0169/6995/7440/products/E6830_Transformers_War_For_Cybertron_Unicron_07_2000x.jpg?v=1570035387');
-- 6
Insert into Products(name,price,description ,pic1,pic2) values
('Bat',50.0,'Not sure which one we are selling','https://atlas-content1-cdn.pixelsquid.com/assets_v2/10/1090037177007478147/jpeg-600/G03.jpg','https://cdn.britannica.com/21/75121-050-8CF5E1DB/Bats-structures-organs-sound-frequencies-signals-contexts.jpg');
-- 7
Insert into Products(name,price,description,pic1,pic2,pic3) values
('Chips',2.0,'Not Healthy','https://www.ubuy.com.ro/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvODF2SnliNDNVUkwuX1NMMTUwMF8uanBn.jpg','https://www.cora.ro/images/products/2628637/gallery/2628637_hd_1.jpg','https://static.euforia-mall.ro/p/0/525/lays-chips-20g-barbecue-143923.jpg');
-- 8
Insert into Products(name,price,description,pic1,pic2,pic3) value
('Skis',300.0,'When you want to go fast','https://fischerskishop.ro/wp-content/uploads/2020/08/A04019.jpg','https://img1.sportconcept.ro/backend_nou/content/images/-xtr-rc-one-73-rt-+-rs-10-gw-20191003171835.jpg','https://s13emagst.akamaized.net/products/41671/41670483/images/res_45d645eda4f094ba50da8dc0e2b50eeb.jpg?width=720&height=720&hash=60730FF629B00D3861F5BB822E9A7215');

-- 9
Insert into Products(name,price,description,pic1,pic2) value
('The Legend of Zelda: Breath of the Wild',60.0,'Action-Adventure Game. 2017 Game of the year','https://m.media-amazon.com/images/I/61wcjVPx4sL._SL1000_.jpg','https://cdn.pocket-lint.com/r/s/1200x/assets/images/137952-games-review-the-legend-of-zelda-breath-of-the-wild-review-image1-tbvqza2wel.jpg');

-- 10
Insert into Products(name,price,description,pic1) value
('Wine',1500.0,'18+ Only. Various assortments, only one.','https://www.wine-searcher.com/images/labels/62/52/10676252.jpg');

Insert into Orders(idUser,idProduct,quantity,seen_by_worker ) values
    (1,1,10,true),
    (2,3,4,false),
    (3,2,7,true);