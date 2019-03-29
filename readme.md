###

常见算法思想：

    a) 贪心       greedy
        限制值、期望值、贡献度
        在限制值范围内，同等贡献度情况下，尽可能的满足期望值
    
    b) 分治       divide and conquer
        分而治之
        问题可分解多个子问题，且子问题没有传递性，合并子问题不复杂情况下使用
    
    c) 回溯       backtracking
        类似枚举、几乎能解决所有问题
        分多个阶段决策，每阶段处理多种策略，通过剪枝或备忘录方式优化代码
    
    d) 动态规划    dynamic programming
        多阶段决策最优解模型、(最有子结构、无后效应、重复则问题)
        学习方式：
            1.实现回溯思想代码
            2.画树形递归函数
            3.总结DP状态（定义状态、状态转移方程、边界条件）
            4.画状态转移表
            5.根据状态转移表写代码
            
    
算法网站:

    中文: https://leetcode-cn.com
    英文: https://leetcode.com

复杂度(O):

    http://bigocheatsheet.com/
    
    时间复杂度:
        1.常数、系数、底数可忽略（大O表示随着规模的增长，时间维度的趋势）
        2.最高规模: 多行代码只计算最大执行次数行
        3.乘法方式: 嵌套循环（包括相同规模或不同规模）递归调用
        4.加法方式: 不同规模串行代码书写方式
    空间复杂度:
        1.最高规模
        
递归模板:
    
    recursion(level, param1,param2,...) :
    
      # recursion terminator
      if level > maxLevel:
          print_result
          return
    
      # precess logic in current level
      process_data(level,data ...)
    
      # drill down
      self.recursion(level+1,p1,...)
    
      # reverse the current level status if needed (此处是已经处理完[level+1]层，然后做的一些收尾逻辑)
      reverse_state(level)
     
分治模板:
    
    divide_conquer(problem, param1,param2,...) :
    
      # recursion terminator
      if problem is None:
          print_result
          return
    
      # prepare data
      data = prepare_data(problem)
      subproblem = split_problem(problem,data)
    
      #conquer subproblem
      subresult1 = self.divide_conquer(subproblem[0],p1,...)
      subresult2 = self.divide_conquer(subproblem[1],p1,...)
      subresult3 = self.divide_conquer(subproblem[2],p1,...)
      ...
    
      # process and generate the final result
      result = process(subresult1,subresult2,subresult3,...)
      
二分查找模板:
    
    binary_search(data,left,right,target) :
      
      loop left<=right : 
        mid = left + ((right-left)>>>2)
        if data[mid] == target :
          return mid
        elsif data[mid] < target :
          left = mid + 1
        els
          right = mid - 1
          
      return -1
      



动态规划习题:

    1. https://leetcode.com/problems/climbing-stairs/description/
    2. https://leetcode.com/problems/triangle/description/
    3. https://leetcode.com/problems/maximum-product-subarray/description/
    4. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
    5. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    6. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    7. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    8. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    9. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    10.https://leetcode.com/problems/longest-increasing-subsequence 
    11.https://leetcode.com/problems/coin-change/ 
    12.https://leetcode.com/problems/edit-distance/