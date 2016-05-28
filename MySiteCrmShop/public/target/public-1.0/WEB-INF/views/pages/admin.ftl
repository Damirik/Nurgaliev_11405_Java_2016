<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="AdminPanel"/>
<#macro m_body>



<div class="category">
    <div class="l-center">
        <p class="authWrapper__note">Adding item</p>
        <form action="/item/add" class="form" id="reg" method="post">

            <fieldset class="form__group">
                <label class="form__label form__label__add">ID</label>
                <input class="form__field" size="50" type="text" name="id">
            </fieldset>

            <fieldset class="form__group">
                <label class="form__label form__label__add">company</label>
                <input class="form__field" size="50" type="text" name="company">
            </fieldset>

            <fieldset class="form__group">
                <label class="form__label form__label__add">description</label>
                <input class="form__field" size="50" type="text" name="description">
            </fieldset>
            <fieldset class="form__group">
                <label class="form__label form__label__add">name</label>
                <input class="form__field" size="50" type="text" name="name">
            </fieldset>
            <fieldset class="form__group">
                <label class="form__label form__label__add">price</label>
                <input class="form__field" size="50" type="text" name="price">
            </fieldset>
            <fieldset class="form__group">
                <label class="form__label form__label__add">image</label>
                <input class="form__field" size="50" type="text" name="image">
            </fieldset>
            <fieldset class="form__group">
                <label class="form__label form__label__add">category</label>
                <input class="form__field" size="50" type="text" name="category">
            </fieldset>

            <fieldset class="form__group-submit">
                <input type="submit" value="Add item">
            </fieldset>
            <br>
            <br>
        </form>

    </div>
</div>



</#macro>