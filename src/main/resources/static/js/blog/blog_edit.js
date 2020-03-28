var editorContent;
$(function() {

  editorContent = editormd("editormd_content", {
    width: "100%",
    height: 640,
    syncScrolling: "single",
    //这个lib路径和项目里面对应
    path: "/js/plugins/editormd/lib/",
    saveHTMLToTextarea: true
  });
  $("#confirmButton").bind("click", saveBlog);

});

function  saveBlog(){
  var blogContent = editorContent.getMarkdown();
  var blog_title = $("#blog_title").val();
  var blog_author = $("#blog_author").val();
  $.ajax({
    url :  "/blog/saveBlog",
    type : "post",
    data : {
      "blogContent":blogContent,
      "blog_title":blog_title,
      "blog_author":blog_author,
    },
    async : false,
    success : function(result) {
      alert("保存博客成功");
      showBlogList();
    }
  });
}

function showBlogList(){
    window.location = '/blog/showBlogList';

}