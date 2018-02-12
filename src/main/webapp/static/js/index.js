
function initData() {
    $.ajax({
        url:"/initData",
        type:"post",
        success:function (data) {
            let str = "";
            if(data.mes.length > 0){
                data.mes.forEach((val)=>{
                    str += `
                            <li id="begin-dk">开始时间：${val.sdata}结束时间：${val.sdata}备注：${val.bz}</li>
                        `
                });
            }else{
                str = `<li style="color: indianred">无历史打卡记录</li>`
            }
            $("#list-hys-item").html(str);
        }
    })
};
function beginDk() {
    $.ajax({
        url:"clockInStart",
        type:"post",
        data:{
            bz:$("#begin-box-bz").val(),
        },
        success(data){
            let str;
            if(data.type){
                str = `
                    <h3>正在打卡</h3>
                    <div>开始时间：${data.data.time}</div>
                    <div>备注：${data.data.bz}</div>
                    <button id="end-dk">结束打卡</button>
                `
                $("#begin-box").hide();
            }else{
                str = `
                打卡失败，请重新点击打卡！
                `
            }
            $("#begin-ing").show().html(str);
            $("#end-dk").click(function () {
                $.ajax({
                    url:"/addItemData",
                    type:"post",
                    success(data){
                        if(data){
                            $("#begin-ing").html("打卡成功！");
                            setTimeout(()=>{
                                $("#begin-ing").hide();
                                $("#begin-box").show();
                            },1500);
                        }
                    }
                })
            });
        }
    })
}
$.ajax({
    url:"/initDatas",
    type:"post",
    success:function (data) {
        if(!data.unfinishedType){
            initData();
        }else{
            location.href = "/progress"
        }
    }
})