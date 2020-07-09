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
  $("#updateButton").bind("click", updateBlog);

});

function  updateBlog(){
  var blogContent = editorContent.getMarkdown();
  var blog_title = $("#blog_title").val();
  var blog_author = $("#blog_author").val();
  var blog_id=$("#blog_id").val();

  $.ajax({
    url :  "/blog/updateBlog",
    type : "post",
    data : {
      "blogContent":blogContent,
      "blog_title":blog_title,
      "blog_author":blog_author,
      "blog_id":blog_id,

    },
    async : false,
    success : function(result) {
      alert("修改博客成功");
      showBlogList();
    }
  });
}

function showBlogList(){
  window.location = '/blog/showBlogList';

}