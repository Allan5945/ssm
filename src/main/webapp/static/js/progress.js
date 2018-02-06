$.ajax({
    url:"/initProgress",
    type:"post",
    success:function (data) {
        if(data.type){ // 有未完后的进度
            let str = `
                     <h4>sorry!你有未完成的打卡进度！</h4>
                     <div>
                        时间：${data.unfinishedData.sdata}备注：${data.unfinishedData.bz}
                         <button>继续打卡</button>
                     </div>
                    
                `;
            $("#propress-err").html(str);
        }
        console.log(data)
    }
})