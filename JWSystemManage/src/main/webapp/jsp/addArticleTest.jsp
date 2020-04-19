 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>static/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
<script src="<%=basePath%>static/js/jquery.js"></script>
<script src="<%=basePath%>static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加阅读题</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>test/addMultipleChoiceTest">  
      <div class="form-group">
        <div class="label">
          <label>文章标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleTitle" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>请设置文章内容：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleText"  />
          <div class="tips"></div>
        </div>
      </div>     
      
       <div class="form-group">
        <div class="label">
          <label>请设置问题一：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleQuestionOne" />
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>请设置问题一选项A：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerA"  />
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>请设置问题一选项B：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerB"/>
          <div class="tips"></div>
        </div>
      </div>     
      <div class="form-group">
        <div class="label">
          <label>请设置问题一选项C：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerC"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>请设置问题一选项D：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerD"/>
          <div class="tips"></div>
        </div>
      </div>          
       <div class="form-group">
        <div class="label">
          <label>请设置正确选项（A、B、C、D）:</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnsweroneRight" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>请设置问题二：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleQuestionTwo"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>请设置问题二选项A：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerTwoA"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>请设置问题二选项B：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerTwoB"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>请设置问题二选项C：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerTwoC"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>请设置问题二选项D：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerTwoD"/>
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>请设置正确选项（A、B、C、D）:</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerTwoRight" />
          <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
        <div class="label">
          <label>请设置问题三：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleQuestionThree"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>请设置问题三选项A：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerThreeA"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>请设置问题三选项B：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerThreeB"/>
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>请设置问题三选项C：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerThreeC"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>请设置问题三选项D：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerThreeD"/>
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>请设置正确选项（A、B、C、D）:</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerThreeright" />
          <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
        <div class="label">
          <label>请设置问题四：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleQuestionFour"/>
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>请设置问题四选项A：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerFourA"/>
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>请设置问题四选项B：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerFourB"/>
          <div class="tips"></div>
        </div>
      </div>             
      <div class="form-group">
        <div class="label">
          <label>请设置问题四选项C:</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerFourC"/>
          <div class="tips"></div>
        </div>
      </div>             
      <div class="form-group">
        <div class="label">
          <label>请设置问题四选项D：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerFourD"/>
          <div class="tips"></div>
        </div>
      </div> 
           
      <div class="form-group">
        <div class="label">
          <label>请设置正确选项（A、B、C、D）:</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="articleAnswerFourRight"/>
          <div class="tips"></div>
        </div>
      </div>                                                                                                                                
      <div class="form-group">
        <div class="label" >
          <label>题目难易程度：</label>
        </div>
        <div class="field" style="display: inline;">
          <input type="text" class="input w50" th:field="*{input}" placeholder="请选择题目难易程度"  list="listItem" name="articleIsDifficulty"/>
          <datalist id="listItem">
	        <option>容易</option>
	        <option>一般</option>
	        <option>困难</option>
		</datalist> 
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>出题时间：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" value="testUpLoadDate" name="articleUpLoadDate"/>
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>操作人：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${userName}" name="fkUserName"/>
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">增加</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>