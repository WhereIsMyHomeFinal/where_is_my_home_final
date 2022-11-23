use ssafyvue;
drop table memo;
drop table board;
drop table ssafy_member;

update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/0196b54f26f9acf5779f382bd26ae598/house04.jpg' 
where no=201;
update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/ec8accea518301563c8feb9c8a12524b/house05.png' 
where no=30362;
update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/5dca19f2821ce272eafd01a35d64eb2e/house06.png' 
where no=202;

update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/e04ab3d8a3cb6fe198887cecdad0f8d4/house07.png' 
where no= 59238;
update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/f0f18e3df3ff40c9cd7984b094f4fd11/house08.png' 
where no= 211;
update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/8a93cc1ec65e0d2b6735e18ed5cc6c1c/house09.png' 
where no= 30927;
update housedeal SET imgUrl='https://lab.ssafy.com/ekdub92/whereismyhome08_7/uploads/3aee0e52819f371491fea396fbe95e07/house10.png' 
where no= 29082;

insert into likedeal (deal_idx, user_idx) values(399, 1);
insert into likedeal (deal_idx, user_idx) values(27162, 1);
insert into likedeal (deal_idx, user_idx) values(466, 1);
insert into likedeal (deal_idx, user_idx) values(28412, 1);
insert into likedeal (deal_idx, user_idx) values(201, 1);
insert into likedeal (deal_idx, user_idx) values(30362, 1);
insert into likedeal (deal_idx, user_idx) values(202, 1);
insert into likedeal (deal_idx, user_idx) values(59238, 1);
insert into likedeal (deal_idx, user_idx) values(211, 1);
insert into likedeal (deal_idx, user_idx) values(30927, 1);
insert into likedeal (deal_idx, user_idx) values(29082, 1);
ALTER TABLE housedeal ADD imgUrl varchar(500) default 'https://images.unsplash.com/photo-1507089947368-19c1da9775ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2255&q=80';

insert into ssafy_member (userid, username, userpwd, email) values('apple', '김수영', '1234', 'apple@ssafy.com');
insert into ssafy_member (userid, username, userpwd, email) values('hello', '이현민', '1234', 'hello@ssafy.com');

insert into review (deal_idx, user_idx, recommend_score, surround_score, traffic_score, living_score, comment) values(399, 3, 3, 5, 4, 2, '학군과 주변 환경이 좋습니다.');
insert into review (deal_idx, user_idx, recommend_score, surround_score, traffic_score, living_score, comment) values(399, 4, 4, 3, 5, 4, '문화 시설이 많습니다.');

select * from housedeal where no=399;
select * from houseinfo where aptCode = 29;
select * from review;

select r.review_idx as reviewIdx, r.deal_idx as dealIdx, r.user_idx as userIdx, s.username as userName,
				r.recommend_score as recommendScore, r.surround_score as surroundScore, r.traffic_score as trafficScore,
				r.living_score as livingScore, comment, r.regist_date as registDate
		from review r join ssafy_member s
		on r.user_idx = s.user_idx
        where deal_idx = 399;
        
select l.deal_idx as dealIdx, l.user_idx as userIdx, h.aptCode, i.aptName, h.dealAmount, h.area, i.dongName, h.floor, i.buildYear, h.imgUrl
		from likedeal l
		join housedeal h
		on l.deal_idx = h.no
		join houseinfo i
		on h.aptCode = i.aptCode
		where user_idx = 1;
        
select * from likedeal;
select * from housedeal where no = 27162;

select d.no, d.aptCode, i.aptName, d.dealAmount, d.area, i.dongName, d.floor, i.buildYear,
		i.lat, i.lng
		from housedeal d join houseinfo i on d.aptCode = i.aptCode
        where aptName like concat('%', "풍림", '%') order by dealAmount desc;
        
select distinct(aptName) from houseinfo where aptName like concat('%', "풍림", '%');
select d.no, i.aptName from housedeal d join houseinfo i on d.aptCode = i.aptCode where aptName like concat('%', "풍림", '%');
select d.no, d.aptCode, i.aptName, d.dealAmount, d.area, i.dongName, d.floor, i.buildYear,
		i.lat, i.lng,
		EXISTS (select * from likedeal where user_idx= 1 and deal_idx = 399) as isLiked
		from housedeal d join houseinfo i on d.aptCode = i.aptCode
		where d.no = 399;
-- 		<where>
-- 			<if test="ap-- tName != '' and aptName != null">aptName like concat('%', #{aptName}, '%')</if>
-- 			<if test="dongName != '' and dongName != null">and dongName like #{dongName}</if>	<!-- 첫번째 if가 실행안되면 and 자동으로 날려줌!! -->
-- 		</where>
-- 		order by dealAmount desc

select * from (select *, row_number() over (partition by aptCode) as rn
    from (select * from housedeal d right join houseinfo i
        using (aptCode)) as t
    ) as a
    where a.rn <= 1 and aptCode = 29
    order by dealAmount desc;

select * from (select *, row_number() over (partition by aptCode) as rn
    from (select * from housedeal d right join houseinfo i using (aptCode)) as t
    ) as a
	right join (select * from review r1 join housedeal d1 on r1.deal_idx = d1.no where aptCode = 29) as b on a.aptCode = b.aptCode
    where a.rn <= 1
    
    order by a.dealAmount desc;
    
select aptCode, avg(recommend_score) as avgRecScore from housedeal d2 left join review r2 on d2.no = r2.deal_idx where aptCode = 29 group by aptCode;

select * from review r1 join housedeal d1 on r1.deal_idx = d1.no where aptCode = 29;

select * from review;
select * from housedeal d 
join houseinfo i on d.aptCode = i.aptCode
where i.aptCode = 29;

update review set deal_idx = 549 where review_idx = 4;

select no, aptCode, aptName, dealAmount, area, dongName,
	floor, buildYear, lat, lng, isLiked from (select *, row_number() over (partition by aptCode) as rn
    from (select * from housedeal d right join houseinfo i
        using (aptCode)) as t
    ) as a
    where a.rn <= 1 and aptCode = 29
    order by dealAmount desc;

