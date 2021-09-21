//累计用户数
SELECT SUM(num_registered) as numRegistered FROM tb_analysis_by_day;

//过去7天活跃用户
SELECT SUM(num_active) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-09-01'

//过去30天活跃用户
SELECT SUM(num_active) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-08-09';

//今日新增用户
SELECT SUM(num_registered) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-09-08'

//今日登录次数
SELECT SUM(num_login) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >='2020-09-08'

//今日活跃用户
SELECT SUM(num_active) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-09-08'


//新增用户数
SELECT record_date , num_registered as num_active FROM tb_analysis_by_day WHERE record_date >= '2021-02-24' AND record_date <= '2021-03-03'
SELECT record_date , num_registered as num_active FROM tb_analysis_by_day WHERE record_date >= '2020-02-24' AND record_date <= '2020-03-03' 

//活跃用户
SELECT record_date , num_active as num_active FROM tb_analysis_by_day WHERE record_date >= '2021-02-24' AND record_date <= '2021-03-03'
SELECT record_date , num_active as num_active FROM tb_analysis_by_day WHERE record_date >= '2020-02-24' AND record_date <= '2020-03-03'

//次日留存率
SELECT record_date , num_retention1d as num_active FROM tb_analysis_by_day WHERE record_date >= '2021-02-24' AND record_date <= '2021-03-03'
SELECT record_date , num_retention1d as num_active FROM tb_analysis_by_day WHERE record_date >= '2020-02-24' AND record_date <= '2020-03-03'
